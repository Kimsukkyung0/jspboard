<script>
    let CDate = new Date();
    let today = new Date();

    $(document).ready(function() {
        // 메뉴 클릭시 색상 변화
        $(function () {
            $(".aside-menu .inner:nth-child(1) ul li:nth-child(1)").addClass(
                'act');
        });
        buildCalender();

    });

    function buildCalender(){
        let prevLast = new Date(CDate.getFullYear(), CDate.getMonth(), 0);
        let thisFirst = new Date(CDate.getFullYear(), CDate.getMonth(), 1);
        let thisLast = new Date(CDate.getFullYear(), CDate.getMonth() + 1, 0);
        $(".yearMonthTitle").html(CDate.getFullYear() +' .' + (CDate.getMonth() + 1));
        let dates = [];
        if(thisFirst.getDay()!==0){
            for(let i = 0; i < thisFirst.getDay(); i++){
                dates.unshift(prevLast.getDate()-i);
            }
        }
        for(let i = 1; i <= thisLast.getDate(); i++){
            dates.push(i);
        }
        for(let i = 1; i <= 13 - thisLast.getDay(); i++){
            dates.push(i);
        }
        let htmlDates = '';
        for(let i = 0; i < 42; i++){
            if(today.getDate()===dates[i] && today.getMonth()===CDate.getMonth() && today.getFullYear()===CDate.getFullYear()){
                htmlDates += `<div class="date today">`+dates[i]+`</div>`;
            }
            else{
                htmlDates += `<div class="date">`+dates[i]+`</div>`;
            }
        }

        console.log("htmlDates:",htmlDates)
        $(".dates").html(htmlDates);
    }

    function prevCal(){
        CDate.setMonth(CDate.getMonth()-1);
        buildCalender();
    }

    function nextCal(){
        CDate.setMonth(CDate.getMonth()+1);
        buildCalender();
    }

</script>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<div class="boxed mt30">
    <div class="inner">
        <div class="item">
            <div class="tit">
                <h4>휴무캘린더</h4>
            </div>
            <div  id="calendar-container">
                <div class="calender">
                    <div class="header">
                        <button class="prevBtn" onclick="prevCal()"></button>
                        <div class="title">
                            <div class="yearMonthTitle"></div>
                        </div>
                        <button class="nextBtn" onclick="nextCal()"></button>
                    </div>
                    <div class="main">
                        <div class="daies">
                            <div class="day">Sun</div>
                            <div class="day">Mon</div>
                            <div class="day">Tue</div>
                            <div class="day">Wed</div>
                            <div class="day">Thu</div>
                            <div class="day">Fri</div>
                            <div class="day">Sat</div>
                        </div>
                        <div class="dates"></div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>