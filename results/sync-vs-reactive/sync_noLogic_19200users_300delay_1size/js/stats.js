var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "576000",
        "ok": "300000",
        "ko": "276000"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "302",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "18063",
        "ok": "18063",
        "ko": "0"
    },
    "meanResponseTime": {
        "total": "6786",
        "ok": "13029",
        "ko": "0"
    },
    "standardDeviation": {
        "total": "6692",
        "ok": "2158",
        "ko": "0"
    },
    "percentiles1": {
        "total": "7183",
        "ok": "13671",
        "ko": "0"
    },
    "percentiles2": {
        "total": "13673",
        "ok": "13694",
        "ko": "0"
    },
    "percentiles3": {
        "total": "13713",
        "ok": "13722",
        "ko": "0"
    },
    "percentiles4": {
        "total": "13735",
        "ok": "13742",
        "ko": "0"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 1857,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 493,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 297650,
        "percentage": 52
    },
    "group4": {
        "name": "failed",
        "count": 276000,
        "percentage": 48
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "1257.642",
        "ok": "655.022",
        "ko": "602.62"
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
        "total": "576000",
        "ok": "300000",
        "ko": "276000"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "302",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "18063",
        "ok": "18063",
        "ko": "0"
    },
    "meanResponseTime": {
        "total": "6786",
        "ok": "13029",
        "ko": "0"
    },
    "standardDeviation": {
        "total": "6692",
        "ok": "2158",
        "ko": "0"
    },
    "percentiles1": {
        "total": "7203",
        "ok": "13671",
        "ko": "0"
    },
    "percentiles2": {
        "total": "13673",
        "ok": "13694",
        "ko": "0"
    },
    "percentiles3": {
        "total": "13713",
        "ok": "13722",
        "ko": "0"
    },
    "percentiles4": {
        "total": "13735",
        "ok": "13742",
        "ko": "0"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 1857,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 493,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 297650,
        "percentage": 52
    },
    "group4": {
        "name": "failed",
        "count": 276000,
        "percentage": 48
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "1257.642",
        "ok": "655.022",
        "ko": "602.62"
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
