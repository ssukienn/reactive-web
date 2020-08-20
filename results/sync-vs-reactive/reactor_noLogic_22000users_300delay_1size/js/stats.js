var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "660000",
        "ok": "660000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "301",
        "ok": "301",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "9893",
        "ok": "9893",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "875",
        "ok": "875",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "623",
        "ok": "623",
        "ko": "-"
    },
    "percentiles1": {
        "total": "725",
        "ok": "726",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1219",
        "ok": "1219",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1978",
        "ok": "1978",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2387",
        "ok": "2388",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 354270,
        "percentage": 54
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 135347,
        "percentage": 21
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 170383,
        "percentage": 26
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "6226.415",
        "ok": "6226.415",
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
        "total": "660000",
        "ok": "660000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "301",
        "ok": "301",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "9893",
        "ok": "9893",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "875",
        "ok": "875",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "623",
        "ok": "623",
        "ko": "-"
    },
    "percentiles1": {
        "total": "725",
        "ok": "726",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1219",
        "ok": "1219",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1978",
        "ok": "1978",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2387",
        "ok": "2387",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 354270,
        "percentage": 54
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 135347,
        "percentage": 21
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 170383,
        "percentage": 26
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "6226.415",
        "ok": "6226.415",
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
