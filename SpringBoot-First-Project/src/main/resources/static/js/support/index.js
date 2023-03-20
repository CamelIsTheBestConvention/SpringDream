// {
//     const fileInput = document.getElementById("request-attachments");
//     {/* 또는 const fileInput = $("#fileUpload").get(0); */ }

//     fileInput.onchange = () => {
//         const selectedFile = [...fileInput.files];
//         // console.log(selectedFile);
//     };
//     fileInput.addEventListener("change", handleFiles);
// }

{
    $("#file").on('change', function () {
        const selectedFile = [...fileInput.files];
    });
    fileInput.addEventListener("change", handleFiles);

}

{
    $("#file").on('change', function () {
        var fileName = $("#file").val();
        $(".upload-name").val(fileName);
    });
}

{
    function readURL(input) {
        if (input.files && input.files[0]) {
          var reader = new FileReader();
          reader.onload = function(e) {
            document.getElementById('preview').src = e.target.result;
          };
          reader.readAsDataURL(input.files[0]);
        } else {
          document.getElementById('preview').src = "";
        }
      }
}