<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<div id="chartContainer" style="height: 300px; width: 100%;"></div>
		<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
		<script>
			window.onload = function () {
			
			var chart = new CanvasJS.Chart("chartContainer", {
				animationEnabled: true,
				theme: "light2",
				// width: 320,
				title:{
					text: "P/L"
				},
				axisY:{
					includeZero: false
				},
				data: [{        
					type: "line",       
					dataPoints: [
						{ y: 1450000, label: "19-1"},
						{ y: 1410000, label: "19-2"},
						{ y: 1520000, label: "19-3"},
						{ y: 1460000, label: "19-4"}
					]
				}]
			});
			chart.render();
			}
		</script>