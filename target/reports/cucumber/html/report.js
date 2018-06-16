$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CitesAreConnected.feature");
formatter.feature({
  "line": 1,
  "name": "Two cities are passed through an endpoint to see if they exist",
  "description": "",
  "id": "two-cities-are-passed-through-an-endpoint-to-see-if-they-exist",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Passing two cities in parameter which contains in a text file should return a yes",
  "description": "",
  "id": "two-cities-are-passed-through-an-endpoint-to-see-if-they-exist;passing-two-cities-in-parameter-which-contains-in-a-text-file-should-return-a-yes",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the origin city and destination city",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "ConnectedController endpoint is executed with the origin city and destination city",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "it should return a yes to client",
  "keyword": "Then "
});
formatter.match({
  "location": "CitiesAreConnected.the_origin_city_and_destination_city()"
});
formatter.result({
  "duration": 162188015,
  "status": "passed"
});
formatter.match({
  "location": "CitiesAreConnected.connectedcontroller_endpoint_is_executed_with_the_origin_city_and_destination_city()"
});
formatter.result({
  "duration": 181437307,
  "status": "passed"
});
formatter.match({
  "location": "CitiesAreConnected.it_should_return_a_yes_to_client()"
});
formatter.result({
  "duration": 153955,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Passing two cities in parameter which does not contain in a text file should return a no",
  "description": "",
  "id": "two-cities-are-passed-through-an-endpoint-to-see-if-they-exist;passing-two-cities-in-parameter-which-does-not-contain-in-a-text-file-should-return-a-no",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "the wrong origin city and destination city",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "ConnectedController endpoint is executed with the wrong origin city and destination city",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "it should return a no to client",
  "keyword": "Then "
});
formatter.match({
  "location": "CitiesAreNotConnected.the_origin_city_and_destination_city()"
});
formatter.result({
  "duration": 3770458,
  "status": "passed"
});
formatter.match({
  "location": "CitiesAreNotConnected.connectedcontroller_endpoint_is_executed_with_the_origin_city_and_destination_city()"
});
formatter.result({
  "duration": 13181415,
  "status": "passed"
});
formatter.match({
  "location": "CitiesAreNotConnected.it_should_return_a_yes_to_client()"
});
formatter.result({
  "duration": 78004,
  "status": "passed"
});
});