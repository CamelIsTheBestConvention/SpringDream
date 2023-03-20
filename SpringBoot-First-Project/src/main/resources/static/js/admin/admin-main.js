let $pages = $("a.changePage");

$pages.on("click", function(e){
    e.preventDefault();
    $(document.pageForm.page).val($(this).attr("href"));
    document.pageForm.submit();
});