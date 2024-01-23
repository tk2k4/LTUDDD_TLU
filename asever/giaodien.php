<!doctype html>
<?php
session_start();
require_once('Data.php');
global $result;
?>
<html lang="en">
  <head>
    <title>Quản trị sản phẩm</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <div class="jumbotron">
        <h1 class="display-3">
            <center style="font-size: 58px">
                Quản trị sản phẩm
            </center>
        </h1>
    
    </div>  
</head>
  <body>
    <div class="card-columns">
        <div class="card">
            <img class="card-img-top" src="holder.js/100x180/" alt="">
            <div class="card-body">
                <h4 class="card-title">Thông tin sản phẩm</h4>
                <form action="" method="post">
                    <div class="form-group">
                      <label for="">Mã sản phẩm</label>
                      <input type="text"
                        class="form-control" name="txtMSP" id="txtMSP" aria-describedby="" placeholder="Nhập mã sản phẩm">
                      
                    </div>
                    <div class="form-group">
                        <label for="">Tên sản phẩm</label>
                        <input type="text"
                          class="form-control" name="txtTSP" id="txtTSP" aria-describedby="" placeholder="Nhập tên sản phẩm">
                        
                    </div>
                    <div class="form-group">
                        <label for="">Đơn vị tính</label>
                        <input type="text"
                            class="form-control" name="txtDVT" id="txtDVT" aria-describedby="" placeholder="Nhập đơn vị tính">
                    
                    </div>
                        <div class="form-group">
                        <label for="">Đơn giá</label>
                        <input type="text"
                            class="form-control" name="txtDG" id="txtDG" aria-describedby="" placeholder="Nhập đơn giá">
                    
                    </div>
                        <div class="form-group">
                        <label for="">Nhà cung cấp</label>
                        <input type="text"
                            class="form-control" name="txtNCC" id="txtNCC" aria-describedby="" placeholder="Nhập nhà cung cấp">
                    
                    </div>
                    <button type="Submit" name="btnThem" value="btnThem" class="btn btn-primary" btn-lg btn-block">Thêm</button>
                    <button type="Submit" name="btnHienThi" value="btnHienThi" class="btn btn-primary" btn-lg btn-block">Hiển thị</button>
                    <button type="Submit" name="btnUpload" value="btnUpload" class="btn btn-primary" btn-lg btn-block">Upload</button>
                </form>
            </div>
        </div>
        <div class="card">
            <img class="card-img-top" src="holder.js/100x180/" alt="">
            <div class="card-body">
                <h4 class="card-title">Hiển thị sản phẩm</h4>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Mã sản phẩm</th>
                            <th>Tên sản phẩm</th>
                            <th>Đơn vị tính</th>
                            <th>Đơn giá</th>
                            <th>Nhà cung cấp</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        if(isset($_POST['btnHienThi'])){
                            $result  = hienthiSP();
                            while($row = $result -> fetch_assoc()) {
                                echo '<tr>';
                                    echo '<td>'.$row['ID'].'</td>';
                                    echo '<td>'.$row['TenSP'].'</td>';
                                    echo '<td>'.$row['DonViTinh'].'</td>';
                                    echo '<td>'.$row['Gia'].'</td>';
                                    echo '<td>'.$row['NhaCungCap'].'</td>';
                                echo '</tr>';
                            }
                        }
                        ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <?php
        if(isset($_POST['btnThem'])){
            $ID = $_POST['txtMSP'];
            $TenSP = $_POST['txtTSP'];
            $DonViTinh = $_POST['txtDVT'];
            $Gia = $_POST['txtDG'];
            $NhaCungCap = $_POST['txtNCC'];
            $i = ThemSanPhamDB($ID, $TenSP, $DonViTinh, $Gia, $NhaCungCap);
            if ($i < 0) {
                echo "them that bai";
            }
            else {
                echo "Them thanh cong";
            }
        }
    ?>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <!-- Code injected by live-server -->
<script>
	// <![CDATA[  <-- For SVG support
	if ('WebSocket' in window) {
		(function () {
			function refreshCSS() {
				var sheets = [].slice.call(document.getElementsByTagName("link"));
				var head = document.getElementsByTagName("head")[0];
				for (var i = 0; i < sheets.length; ++i) {
					var elem = sheets[i];
					var parent = elem.parentElement || head;
					parent.removeChild(elem);
					var rel = elem.rel;
					if (elem.href && typeof rel != "string" || rel.length == 0 || rel.toLowerCase() == "stylesheet") {
						var url = elem.href.replace(/(&|\?)_cacheOverride=\d+/, '');
						elem.href = url + (url.indexOf('?') >= 0 ? '&' : '?') + '_cacheOverride=' + (new Date().valueOf());
					}
					parent.appendChild(elem);
				}
			}
			var protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
			var address = protocol + window.location.host + window.location.pathname + '/ws';
			var socket = new WebSocket(address);
			socket.onmessage = function (msg) {
				if (msg.data == 'reload') window.location.reload();
				else if (msg.data == 'refreshcss') refreshCSS();
			};
			if (sessionStorage && !sessionStorage.getItem('IsThisFirstTime_Log_From_LiveServer')) {
				console.log('Live reload enabled.');
				sessionStorage.setItem('IsThisFirstTime_Log_From_LiveServer', true);
			}
		})();
	}
	else {
		console.error('Upgrade your browser. This Browser is NOT supported WebSocket for Live-Reloading.');
	}
	// ]]>
</script>
</body>
</html>