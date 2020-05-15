<?php
  $id = $_GET['id'];

  require_once('connection.php');

  $sql = "SELECT * FROM mahasiswa WHERE id=$id";

  $r = mysqli_query($conn, $sql);

  $result = array();
  $row = mysqli_fetch_array($r);
  array_push($result, array(
    "id"=>$row["id"],
    "nama"=>$row["nama"],
    "jurusan"=>$row["jurusan"],
    "email"=>$row["email"]
  ));

  echo json_encode(array('result'=>$result));

  mysqli_close($conn);
?>