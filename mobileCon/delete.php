<?php
  $id=$_GET['id'];
  
  require_once('connection.php');

  $sql="DELETE FROM mahasiswa WHERE id=$id";

  if (mysqli_query($conn, $sql)) {
    # code...
    echo "Success delete data where id $id";
  }else{
    echo "Error delete data where id $id";
  }

  mysqli_close($conn);
?>