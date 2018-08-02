// set the size
var canvasW = $(window).width();
var canvasH = 720;

// panel
var panel_canvas = document.getElementById('main_canvas');
panel_canvas.width = canvasW;
panel_canvas.height = canvasH;
var ctx = panel_canvas.getContext('2d');
var ctx2 = panel_canvas.getContext('2d');

var CENTERX = canvasW * 0.5;
var CENTERY = canvasH * 0.5;

// GET POS TRACK
var Pos = function(x, y, index) {
    this.x = x;
    this.y = y;
    this.index = index;
}

function getPosTrackCircular(centerX, centerY, radius, startAngle, endAngle, segNum, motionCurve) {
    var pos_track = [];
    var pr;
    offset = 0;
    for (var i = 0; i <= (segNum - 1); ++i) {
        if (motionCurve) {
            pr = motionCurve[i];
        } else {
            pr = i / segNum;
        }
        var x = centerX + radius * Math.cos((startAngle + pr * (endAngle - startAngle) - offset * Math.cos(Math.PI * pr)) * Math.PI / 180);
        var y = centerY + radius * Math.sin((startAngle + pr * (endAngle - startAngle) - offset * Math.cos(Math.PI * pr)) * Math.PI / 180);
        var pos = new Pos(x, y, i);
        pos_track.push(pos);
    }
    return pos_track;
}

var nebula = [];
var traceNum = 1;
var randomRange = 0;

var frame = 0;

window.requestAnimationFrame = window.requestAnimationFrame || window.mozRequestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame;

var Sparkle = function(startPos, endPos, middlePos) {
    this.startPos = startPos;
    this.endPos = endPos;
    this.middlePos = middlePos;
}
Sparkle.prototype = {

}

var Star = function(starPos, StarAnchor, starOrigin, randomFactor) {
    this.starPos = starPos;
    this.StarAnchor = StarAnchor;
    this.starOrigin = starOrigin;
    this.ran = randomFactor;
}

function init() {
    for (var i = 0; i < traceNum; ++i) {
        var starPosTrack = getPosTrackCircular(0, 0, 100 + 120 * traceNum, 0, 360, 30);
        var starPosTrackOrigin = getPosTrackCircular(0, 0, 1000, 0, 360, 30);
        var trace = [];
        for (var s = 0; s < starPosTrack.length; ++s) {
            var starX = starPosTrack[s].x + generateRandom(-randomRange, randomRange);
            var starY = starPosTrack[s].y + generateRandom(-randomRange, randomRange);
            var StarAnchor = new Pos(starX, starY);
            var starPos = new Pos(starX, starY);

            var starOriginX = starPosTrackOrigin[s].x + generateRandom(-randomRange, randomRange);
            var starOriginY = starPosTrackOrigin[s].y + generateRandom(-randomRange, randomRange);
            var starOrigin = new Pos(starOriginX, starOriginY);

            var randomFactor = generateRandom(-10, 10);

            var star = new Star(starPos, StarAnchor, starOrigin, randomFactor);
            trace.push(star);
        }
        nebula.push(trace)
    }

    // console.log(nebula)

    sparklesArr = [];
    for (var s = 0; s < 2; ++s) {
        var sparklesEndPos = getPosTrackCircular(0, 0, 320, 0, 360, 100);
        shakenPosTrack(sparklesEndPos, 30, true, true);
        var sparklesStartPos = getPosTrackCircular(400, 400, 1500, 0, 360, 100);
        var sparklesMiddlePos = [];
        for (var i = 0; i < 100; ++i) {
            var middle_x = (sparklesEndPos[i].x + sparklesStartPos[i].x) / 2;
            var middle_y = (sparklesEndPos[i].y + sparklesStartPos[i].y) / 2 - 100;
            var pos = new Pos(middle_x, middle_y, i);
            sparklesMiddlePos.push(pos)
        }
        var sparkle = new Sparkle(sparklesStartPos, sparklesEndPos, sparklesMiddlePos);
        sparklesArr.push(sparkle);
    }
}

function run() {
    update();
    ctx.clearRect(0, 0, canvasW, canvasH);
    draw();
    drawSparkles();
    requestAnimationFrame(run);
}

function update() {
    frame++;

    //
    for (var j = 0; j < nebula[0].length; ++j) {
        nebula[0][j].starPos.x = nebula[0][j].StarAnchor.x + Math.cos((frame) * Math.PI / 1720) * 10 * nebula[0][j].ran;
        nebula[0][j].starPos.y = nebula[0][j].StarAnchor.y + Math.sin((frame) * Math.PI / 1720) * 10 * nebula[0][j].ran;
    }

    //
    for (var s = 0; s < 2; ++s) {
        for (var i = 0; i < 100; ++i) {
            sparklesArr[s].endPos[i].y += Math.sin((frame + i + s * 40) * Math.PI / 180) / 2;
        }
    }
}

function drawSparkles() {
    ctx.save();
    ctx.translate(CENTERX, CENTERY);
    ctx.globalCompositeOperation = 'lighter';
    ctx.strokeStyle = '#09f';
    ctx.lineWidth = 0.3;

    for (var s = 0; s < 2; ++s) {
        ctx.save();
        ctx.globalAlpha = 0.3 * s + 0.2;
        for (var i = 0; i < 100; ++i) {
            ctx.beginPath();
            ctx.moveTo(sparklesArr[s].startPos[i].x, sparklesArr[s].startPos[i].y);
            ctx.quadraticCurveTo(sparklesArr[s].middlePos[i].x, sparklesArr[s].middlePos[i].y,
                sparklesArr[s].endPos[i].x, sparklesArr[s].endPos[i].y);
            ctx.stroke();
            ctx.closePath();
            ctx.fillStyle = '#09f';
            ctx.fillRect(sparklesArr[s].endPos[i].x, sparklesArr[s].endPos[i].y, 2 + s * 2, 2 + s * 2);
        }
        ctx.restore();
    }
    ctx.restore();
}

function draw() {
    ctx.save();
    ctx.translate(CENTERX, CENTERY);
    ctx.scale(Math.sin(Math.PI * frame / 180) * 0.03 + 0.97, Math.sin(Math.PI * frame / 180) * 0.03 + 0.97);
    // drawing
    ctx.globalCompositeOperation = 'lighter';
    ctx.strokeStyle = '#09f';
    ctx.fillStyle = '#09c';
    ctx.globalAlpha = 0.2;

    for (var i = 0; i < traceNum; ++i) {
        for (var s = 0; s < nebula[i].length; ++s) {
            for (var count = 0; count < nebula[i].length; ++count) {
                //
                ctx.beginPath();
                ctx.moveTo(nebula[i][s].starPos.x, nebula[i][s].starPos.y);
                ctx.lineTo(nebula[i][count].starPos.x, nebula[i][count].starPos.y);
                var dist = Math.sqrt((nebula[i][count].starPos.x - nebula[i][s].starPos.x) * (nebula[i][count].starPos.x - nebula[i][s].starPos.x) + (nebula[i][count].starPos.y - nebula[i][s].starPos.y) * (nebula[i][count].starPos.y - nebula[i][s].starPos.y));
                if (dist < (260 * traceNum)) {
                    var width = 1.2 - dist / (300 * traceNum)
                    ctx.lineWidth = width * 1;
                    ctx.stroke();
                }
                ctx.closePath();

                //
                ctx.fillRect(nebula[i][s].starPos.x, nebula[i][s].starPos.y, 12, 2);
            }
        }
    }
    ctx.restore();
}

init();
run();

function generateRandom(m, n) {
    return Math.floor(Math.random() * (n - m) + m);
}

function shakenPosTrack(pos_track, num, isX, isY) {
    for (var i = 0; i < pos_track.length; ++i) {
        if (isX) {
            pos_track[i].x += generateRandom(-num, num);
        }
        if (isY) {
            pos_track[i].y += generateRandom(-num, num);
        }
    }
}