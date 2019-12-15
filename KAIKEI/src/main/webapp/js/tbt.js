
$(window).ready(function() {
	var acc_list = ["Asset", "Debt", "Capital", "Profit" ,"Cost"];
	var sum = new Object();

	sum.debbal = 0;
	sum.deb = 0;
	sum.cred = 0;
	sum.credbal = 0;
	
	acc_list.forEach(function(item) {
		sum.debbal = 0;
		sum.deb = 0;
		sum.cred = 0;
		sum.credbal = 0;
		
		for(var i = 0; i < $("." + item).length; i++) {
			sum.debbal += Number($("." + item + ":eq(" + i +")").children(".debbal").text());
			sum.deb += Number($("." + item + ":eq(" + i +")").children(".deb").text());
			sum.cred += Number($("." + item + ":eq(" + i +")").children(".cred").text());
			sum.credbal += Number($("." + item + ":eq(" + i +")").children(".credbal").text());
		}

		$("." + item + ":eq(0)").before(row(item, sum));
	});

	$(".Asset").children(".credbal").text("");
	$(".Debt").children(".debbal").text("");
	$(".Capital").children(".debbal").text("");
	$(".Profit").children(".debbal").text("");
	$(".Cost").children(".credbal").text("");

	acc_list.forEach(function(item) {
		sum.debbal += Number($("." + item + ":eq(0)").children(".debbal").text());
		sum.deb += Number($("." + item + ":eq(0)").children(".deb").text());
		sum.cred += Number($("." + item + ":eq(0)").children(".cred").text());
		sum.credbal += Number($("." + item + ":eq(0)").children(".credbal").text());
	});

	$(".tbt-table").append(row("Total", sum));
})

function row(clf, sum) {

	var item = "";

	item += "<tr class='" + clf + "'>";
	item += "<th class='debbal'>" + sum.debbal + "</th>";
	item += "<th class='deb'>" + sum.deb + "</th>";
	item += "<th>" + clf + "</td>";
	item += "<th class='cred'>" + sum.cred + "</th>";
	item += "<th class='credbal'>" + sum.credbal + "</th>";
	item += "</tr>";

	return item;
	
}