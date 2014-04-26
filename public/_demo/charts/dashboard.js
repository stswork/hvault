(function($){
  if (typeof charts == 'undefined')
    return;
  /* Revenue Chart */
  charts.revenue_chart = {
    // data
    data:{
      d1: []
    },
    // will hold the chart object
    plot: null,
    // chart options
    options: {
      grid: {
        autoHighlight: false,
        backgroundColor: null,
        color: '#7d6ccb',
        borderWidth: 0,
        borderColor: "transparent",
        clickable: true,
        hoverable: true
      },
      series: {
        lines: {
          show: true,
          fill: false,
          lineWidth: 2,
          steps: false
        },
        points: {
          show:true,
          radius: 3,
          lineWidth: 2,
          fill: true,
          fillColor: "#000"
        }
      },
      xaxis: {
        show:false,
        color: '#fff',
        tickColor: '#fff',
        tickDecimals: 2,
        tickSize: 2
      },
      yaxis: {
        tickSize: 500,
        tickColor: '#9e8ee7'
      },
      legend: { show:false },
      shadowSize: 0,
      tooltip: true,
      tooltipOpts: {
        content: "%s : %y.3",
        shifts: {
          x: -30,
          y: -50
        },
        defaultTheme: false
      }
    },
    placeholder: "#revenue-chart",
    // initialize
    init: function(){
        this.options.colors = ["#ffffff"];
        this.options.grid.backgroundColor = null;
      var that = this;
      if (this.plot == null){
        this.data.d1 = [ [6, 1300], [7, 1600], [8, 1900], [9, 2100], [10, 2500], [11, 2200], [12, 2000], [13, 1950], [14, 1900], [15, 2000], [16, 1900], [17, 2300]];
      }
      this.plot = $.plot(
        $(this.placeholder),
        [{
          label: "Data 1",
          data: this.data.d1,
          lines: { fill: 0.00 },
          points: { fillColor: "#806fcd" }
        }], this.options);
    }
  };

  charts.week_sales ={
    // data
    data:{
      d1: []
    },
    // will hold the chart object
    plot: null,
    // chart options
    options: {
      grid: {
        autoHighlight: false,
        backgroundColor: null,
        color: '#7d6ccb',
        borderWidth: 0,
        borderColor: "transparent",
        clickable: true,
        hoverable: true
      },
      series: {
        lines: {
          show: true,
          fill: false,
          lineWidth: 2,
          steps: false
        },
        points: {
          show:true,
          radius: 3,
          lineWidth: 2,
          fill: true,
          fillColor: "#000"
        }
      },
      xaxis: {
        show:true,
        color: '#5dcad3',
        tickColor: '#5dcad3',
        tickDecimals: 2,
        tickSize: 2,
        mode: "categories"
      },
      yaxis: {
        show:false
      },
      legend: { show:false },
      shadowSize: 0,
      tooltip: true,
      tooltipOpts: {
        content: "%s : %y.3",
        shifts: {
          x: -30,
          y: -50
        },
        defaultTheme: false
      }
    },
    placeholder: "#weight-graph",
    // initialize
    init: function(){
        var _url = $(this.placeholder).data().uri;
        console.log(_url);
        var response;
        var thisForAjax = this;
        this.options.colors = ["#ffffff"];
        this.options.grid.backgroundColor = null;
        var that = this;
        $.ajax({
            type: "GET",
            url: _url,
            async: false,
            success: function(data,status,xhr) {
                if(xhr && xhr.status) {
                    if(xhr.status == 200) {
                        $.each(JSON.parse(xhr.responseText), function( index, value ){
                            var arr = [value.created, value.pounds + "." + value.ounces];
                            console.log(arr);
                            thisForAjax.data.d1.push(arr);
                            console.log(thisForAjax.data.d1);
                        });
                    }
                }
            },
            dataType: "json"
        });

        /*if (this.plot == null){
        this.data.d1 = [ ['Sun', 1300], ['Mon', 1600], ['Tue', 1900], ['Wed', 2100], ['Thu', 2500], ['Fri', 2200], ['Sat', 2000] ];
        }*/
        this.plot = $.plot(
        $(this.placeholder),
        [{
          label: "Data 1",
          data: this.data.d1,
          lines: { fill: 0.00 },
          points: { fillColor: "#5ac8d2" }
        }], this.options);
        }
  };

  // ShowTooltips
  function showTooltip(x, y, contents) {
    $('<div class="chart-tooltip">' + contents + '</div>').css( {
      position: 'absolute',
      display: 'none',
      top: y + 5,
      left: x + 5,
      opacity: 0.80
    }).appendTo("body").fadeIn(200);
  }

  // Tooltips
  $('#weight-graph, #revenue-chart').bind("plothover", function (event, pos, item) {
    $("#x").text(pos.x.toFixed(2));
    $("#y").text(pos.y.toFixed(2));

    if (item) {
      if (previousPoint != item.dataIndex) {
        previousPoint = item.dataIndex;

        $(".chart-tooltip").remove();
        var x = item.datapoint[0].toFixed(2),
          y = item.datapoint[1].toFixed(2);

        showTooltip(item.pageX, item.pageY, y);
      }
    }
    else {
      $(".chart-tooltip").remove();
      previousPoint = null;
    }
  });

  // uncomment to init on load
  if ($('#revenue-chart').length) {
    charts.revenue_chart.init();
  }
  if ($('#weight-graph').length) {
    charts.week_sales.init();
  }

})(jQuery);