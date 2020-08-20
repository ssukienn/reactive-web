var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "690000",
        "ok": "689363",
        "ko": "637"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "301",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "20692",
        "ok": "20692",
        "ko": "0"
    },
    "meanResponseTime": {
        "total": "997",
        "ok": "998",
        "ko": "0"
    },
    "standardDeviation": {
        "total": "870",
        "ok": "870",
        "ko": "0"
    },
    "percentiles1": {
        "total": "882",
        "ok": "883",
        "ko": "0"
    },
    "percentiles2": {
        "total": "1371",
        "ok": "1371",
        "ko": "0"
    },
    "percentiles3": {
        "total": "2040",
        "ok": "2041",
        "ko": "0"
    },
    "percentiles4": {
        "total": "2969",
        "ok": "2963",
        "ko": "0"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 317891,
        "percentage": 46
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 140221,
        "percentage": 20
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 231251,
        "percentage": 34
    },
    "group4": {
        "name": "failed",
        "count": 637,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "6052.632",
        "ok": "6047.044",
        "ko": "5.588"
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
        "total": "690000",
        "ok": "689363",
        "ko": "637"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "301",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "20692",
        "ok": "20692",
        "ko": "0"
    },
    "meanResponseTime": {
        "total": "997",
        "ok": "998",
        "ko": "0"
    },
    "standardDeviation": {
        "total": "870",
        "ok": "870",
        "ko": "0"
    },
    "percentiles1": {
        "total": "882",
        "ok": "883",
        "ko": "0"
    },
    "percentiles2": {
        "total": "1371",
        "ok": "1371",
        "ko": "0"
    },
    "percentiles3": {
        "total": "2041",
        "ok": "2041",
        "ko": "0"
    },
    "percentiles4": {
        "total": "2947",
        "ok": "2978",
        "ko": "0"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 317891,
        "percentage": 46
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 140221,
        "percentage": 20
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 231251,
        "percentage": 34
    },
    "group4": {
        "name": "failed",
        "count": 637,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "6052.632",
        "ok": "6047.044",
        "ko": "5.588"
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
