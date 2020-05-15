<?php
  if ($_SERVER['REQUEST_METHOD']=='POST') {
    # code...
    $nama = $_POST['nama'];
    $jurusan = $_POST['jurusan'];
    $email = $_POST['email'];

    $sql = "INSERT INTO mahasiswa (nama, jurusan, email) VALUES ('$nama', '$jurusan', '$email')";

    require_once('connection.php');

    if (mysqli_query($conn, $sql)) {
      # code...
      echo("Success input data to Mahasiswa");
    }else {
      # code...
      echo("Error input data to Mahasiswa");
    }
    mysqli_close($conn);
  }
?>