<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<div style="padding:20px">
	            <span style="font-size: 1.7em;">P/L</span>
	    </div>
	    <hr>
    	<div align="center">
    	<span style="font-size:2em">
    	<!-- <a href="">&lt;</a> --> 2018-2019 <!-- <a href="">&gt;</a> -->
    	</span>
    	</div>
		<div id="chartContainer" style="height: 500px; width: 100%;"></div>
		<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
		<script>
			window.onload = function () {
			
			var chart = new CanvasJS.Chart("chartContainer", {
				animationEnabled: true,
				theme: "light2",
				title: {
					text: "P/L"
				},
				axisX: {
					title: "Quarter",
					crosshair: {
						enabled: true,
						snapToDataPoint: true
					}
				},
				axisY: {
					includeZero: false
				},
				toolTip: {
					shared:true
				},
				legend: {
					cursor:"pointer",
					verticalAlign: "bottom",
					horizontalAlign: "left",
					dockInsidePlotArea: true
				},
				data: [{        
					type: "line",
					name: "2019",
					color: "blue",
					showInLegend: true,
					markerType: "square",
					legendText: "2019",
					dataPoints: [
						{ y: 1450000, label: "Q1", markerColor: "black"},
						{ y: 1410000, label: "Q2", markerColor: "black"},
						{ y: 1520000, label: "Q3", markerColor: "black"},
						{ y: 1460000, label: "Q4", markerColor: "black"}
					]
				}, 
				{        
					type: "line",
					name: "2018",
					color: "green",
					showInLegend: true,
					markerType: "square",
					legendText: "2018",
					dataPoints: [
						{ y: 1350000, label: "Q1", markerColor: "black"},
						{ y: 1510000, label: "Q2", markerColor: "black"},
						{ y: 1120000, label: "Q3", markerColor: "black"},
						{ y: 1260000, label: "Q4", markerColor: "black"}
					]
				}]
			});
			chart.render();
			}
		</script>