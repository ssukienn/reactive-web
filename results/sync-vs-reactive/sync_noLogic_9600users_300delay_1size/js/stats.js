var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "288000",
        "ok": "288000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "302",
        "ok": "302",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "13236",
        "ok": "13236",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "12010",
        "ok": "12010",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "2580",
        "ok": "2580",
        "ko": "-"
    },
    "percentiles1": {
        "total": "13051",
        "ok": "13051",
        "ko": "-"
    },
    "percentiles2": {
        "total": "13096",
        "ok": "13096",
        "ko": "-"
    },
    "percentiles3": {
        "total": "13154",
        "ok": "13154",
        "ko": "-"
    },
    "percentiles4": {
        "total": "13179",
        "ok": "13179",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 2803,
        "percentage": 1
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 833,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 284364,
        "percentage": 99
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "653.061",
        "ok": "653.061",
        "ko": "-"
    }
},
contents: {
"req_no-logic-f13f9": {
        type: "REQUEST",
        name: "no-logic",
path: "no-logic",
pathFormatted: "req_no-logic-f13f9",
stats: {
    "name": "no-logic",
    "numberOfRequests": {
        "total": "288000",
        "ok": "288000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "302",
        "ok": "302",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "13236",
        "ok": "13236",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "12010",
        "ok": "12010",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "2580",
        "ok": "2580",
        "ko": "-"
    },
    "percentiles1": {
        "total": "13051",
        "ok": "13050",
        "ko": "-"
    },
    "percentiles2": {
        "total": "13096",
        "ok": "13096",
        "ko": "-"
    },
    "percentiles3": {
        "total": "13154",
        "ok": "13154",
        "ko": "-"
    },
    "percentiles4": {
        "total": "13179",
        "ok": "13179",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 2803,
        "percentage": 1
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 833,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 284364,
        "percentage": 99
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "653.061",
        "ok": "653.061",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
