<?php
function ketnoiDB() {
    return new mysqli('localhost', 'root', '', 'sever_test');
}
function ThemSanPhamDB($ID, $TenSP, $DonViTinh,$Gia, $NhaCungCap) {
    $con = ketnoiDB();
    $i = $con -> query('INSERT INTO clums VALUES ("'.$ID.'", "'.$TenSP.'", "'.$DonViTinh.'", "'.$Gia.'", "'.$NhaCungCap.'")' );
    return $i;
}

function hienthiSP() {
    $con = ketnoiDB();
    $result = $con ->query('SELECT * FROM clums');
    return $result;
}

function uploadSP($ID, $TenSP, $DonViTinh,$Gia, $NhaCungCap) {
    $con = ketnoiDB();
    $i = $con -> query('UPDATE clums SET  ID=$ID, TenSP=$TenSP, DonViTinh=$DonViTinh, Gia=$Gia, NhaCungCap=$NhaCungCap');
    return $i;
}