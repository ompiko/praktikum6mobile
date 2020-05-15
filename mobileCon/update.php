<?php
  if ($_SERVER['REQUEST_METHOD']=='POST') {
    # code...
    $id=$_POST['id'];
    $nama=$_POST['nama'];
    $jurusan=$_POST['jurusan'];
    $email=$_POST['email'];
    
    require_once('connection.php');

    $sql="UPDATE mahasiswa SET nama = '$nama', jurusan = '$jurusan', email = '$email' WHERE id = '$id'";

    if (mysqli_query($conn, $sql)) {
      # code...
      echo "Success update data to mahasiswa where id $id";
    }else {
      # code...
      echo "Error update data";
    }
    mysqli_close($conn);
  }
?>