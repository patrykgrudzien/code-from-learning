var text = "gotowi na niespodziankę?";
text = text.toUpperCase();

function countDown(secs, elem)
{
    var element = document.getElementById(elem);
    element.innerHTML = text + '<br>' + secs;

    if (secs <= 0)
    {
        element.innerHTML = " ";
        loadNextPageAfterSeconds(1);
        clearTimeout(timer);
    }
    secs--;
    var timer = setTimeout('countDown(' + secs + ',"' + elem + '")', 1000);
}

function loadNextPageAfterSeconds(timeInSeconds)
{
    timeInSeconds = timeInSeconds * 1000;

    setTimeout(function ()
    {
        window.location = '../html/video.html';
    }, timeInSeconds);
}