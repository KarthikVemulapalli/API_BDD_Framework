Feature: Validation RSCourse Maps API

@EndToEnd
Scenario Outline: Verify EndToEnd API
	Given AddPlace Request Payload with <PhoneNumber>
	When User hits "AddPlace" API with "POST" http request
	Then API call response with status code 200
	And Validate Response Payload "status" is "OK"
	And Get Response Payload "place_id" value
	Given DeletePlace Request Payload
	When User hits "DeletePlace" API with "delete" http request
	Then API call response with status code 200
	And Validate Response Payload "status" is "OK"

Examples:
	| PhoneNumber |
	| "(+91) 999 999 9999" |
	| "(+91) 111 111 1111" |

@DeletePlace
Scenario: Verify DeletePlace API
	Given DeletePlace Request Payload
	When User hits "DeletePlace" API with "delete" http request
	Then API call response with status code 200
	And Validate Response Payload "status" is "OK"

@AddPlace
Scenario: Verify AddPlace API
	Given AddPlace Request Payload with "(+91) 999 999 9999"
	When User hits "AddPlace" API with "POST" http request
	Then API call response with status code 200
	And Validate Response Payload "status" is "OK"
	And Get Response Payload "place_id" value