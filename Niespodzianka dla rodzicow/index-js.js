function countDown(secs, elem)
{
    var element = document.getElementById(elem);
    element.innerHTML = secs;

    if (secs <= 0)
    {
        element.innerHTML = " ";
        loadNextPageAfterSeconds(0);
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
        window.location = 'video.html';
    }, timeInSeconds);
}