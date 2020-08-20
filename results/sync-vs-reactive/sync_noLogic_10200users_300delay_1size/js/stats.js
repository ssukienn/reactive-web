var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "306000",
        "ok": "300000",
        "ko": "6000"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "304",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "25736",
        "ok": "25736",
        "ko": "0"
    },
    "meanResponseTime": {
        "total": "12942",
        "ok": "13201",
        "ko": "0"
    },
    "standardDeviation": {
        "total": "2475",
        "ok": "1682",
        "ko": "0"
    },
    "percentiles1": {
        "total": "13676",
        "ok": "13679",
        "ko": "0"
    },
    "percentiles2": {
        "total": "13747",
        "ok": "13748",
        "ko": "0"
    },
    "percentiles3": {
        "total": "13803",
        "ok": "13803",
        "ko": "0"
    },
    "percentiles4": {
        "total": "13825",
        "ok": "13826",
        "ko": "0"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 1,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 299999,
        "percentage": 98
    },
    "group4": {
        "name": "failed",
        "count": 6000,
        "percentage": 2
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "652.452",
        "ok": "639.659",
        "ko": "12.793"
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
        "total": "306000",
        "ok": "300000",
        "ko": "6000"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "304",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "25736",
        "ok": "25736",
        "ko": "0"
    },
    "meanResponseTime": {
        "total": "12942",
        "ok": "13201",
        "ko": "0"
    },
    "standardDeviation": {
        "total": "2475",
        "ok": "1682",
        "ko": "0"
    },
    "percentiles1": {
        "total": "13676",
        "ok": "13678",
        "ko": "0"
    },
    "percentiles2": {
        "total": "13747",
        "ok": "13748",
        "ko": "0"
    },
    "percentiles3": {
        "total": "13803",
        "ok": "13803",
        "ko": "0"
    },
    "percentiles4": {
        "total": "13825",
        "ok": "13826",
        "ko": "0"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 1,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 299999,
        "percentage": 98
    },
    "group4": {
        "name": "failed",
        "count": 6000,
        "percentage": 2
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "652.452",
        "ok": "639.659",
        "ko": "12.793"
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
