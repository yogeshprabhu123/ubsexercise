Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: Midnight
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

Scenario: Afternoon
When the time is 12:00:00
Then the clock should look like
Y
RROO
RROO
OOOOOOOOOOO
OOOO

Scenario: Just after midnight
When the time is 01:01:01
Then the clock should look like
O
OOOO
ROOO
OOOOOOOOOOO
YOOO

Scenario: Missing Hours, Minutes or Seconds
When the time is 01:01
Then the clock should display
null

Scenario: Characters in Input Time
When the time is 01:AB
Then the clock should look like
null

Scenario: Hours, Minutes or Seconds out of bounds
When the time is 25:61:61
Then the clock should look like
null

Scenario: Input Time is NULL
When the time is null
Then the clock should look like
null




