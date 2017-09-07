$(function() {

    Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '2015 Q1',
            moisture: 11
        }, {
            period: '2015 Q2',
            moisture: 18
        }, {
            period: '2015 Q3',
            moisture: 29
        }, {
            period: '2015 Q4',
            moisture: 74
        }, {
            period: '2016 Q1',
            moisture: 92
        }, {
            period: '2016 Q2',
            moisture: 90
        }, {
            period: '2016 Q3',
            moisture: 92
        }, {
            period: '2016 Q4',
            moisture: 55
        }, {
            period: '2017 Q1',
            moisture: 31
        }, {
            period: '2017 Q2',
            moisture: 14
        }],
        xkey: 'period',
        ykeys: ['moisture'],
        labels: ['Moisture Percentage:'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });
});
