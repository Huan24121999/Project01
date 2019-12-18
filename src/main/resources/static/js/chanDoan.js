$(document).ready(function () {

    // $("select.benh").click(function (e) { 
    //     e.preventDefault();
    //     console.log("haha");
        
    // });
    // $("select.benh option").val();
    // $("select.benh option:selected").text();
    
    var lengh=5;
    var lenghTC=10;

    $("button.benh").click(
        function(){
            var benh = [];
            var tenBenh=[];
            $.each($("select.benh option:selected"), function(){            
                benh.push($(this).val());
                tenBenh.push($(this).text());
            });
            alert("Bạn có chắc chắn muốn thêm: " + tenBenh.join(", "));
            for(var i=1;i<=lengh;i++){
                var s="div.themBenh p"+"#"+i+"b";
                if($(s).text()==='chọn'){
                    $(s).text(tenBenh.join(","));
                    break;
                }
                
            }
            
        }
    )

    $("button.benhNhan").click(
        function(){
            var benhNhan = [];
            var tenBenhNhan=[];
            $.each($("select.benhNhan option:selected"), function(){            
                benhNhan.push($(this).val());
                tenBenhNhan.push($(this).text());
            });
            alert("Bạn có chắc chắn muốn thêm:  - " + tenBenhNhan.join(", "));
            for(var i=1;i<=lengh;i++){
                var s="div.themBenhNhan p"+"#"+i+"bn";
                if($(s).text()==='chọn'){
                    $(s).text(tenBenhNhan.join(","));
                    break;
                }
                
            }
            
        }
    )

    $("button.trieuChung").click(
        function(){
            var trieuChung = [];
            var tenTrieuChung=[];
            $.each($("select.trieuChung option:selected"), function(){            
                trieuChung.push($(this).val());
                tenTrieuChung.push($(this).text());
            });
            alert("Bạn có chắc chắn muốn thêm:  - " + tenTrieuChung.join(", "));
            for(var i=1;i<=lenghTC;i++){
                var s="div.themTrieuChung p"+"#"+i+"tc";
                var j;
                // for(j=1;j<i;j++){
                //     var s2="div.themTrieuChung p"+"#"+j+"tc";
                //     if($(s).text()===$(s2).text())
                //     alert("bạn đã chọn "+$(s).text()+ " rồi!");
                //     break;
                // }

                if($(s).text()==='chọn' ){
                    $(s).text(tenTrieuChung.join(","));
                    break;
                }
            }
            
        }
    )



    
});