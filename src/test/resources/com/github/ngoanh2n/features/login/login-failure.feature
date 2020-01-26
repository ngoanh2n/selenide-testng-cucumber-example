############################################
#
# @author ngoanh2n@gmail.com (Ho Huu Ngoan)
#
############################################

@Client
@Login
@LoginFailure
Feature: Gitlab
  test login function for client

  Scenario Outline: LoginPage
  to confirm that login function works well
    Given I open Gitlab page
    When I input username with "<username>"
    And I input password with "<password>"
    And I click Sign In button
    Then I see alert status is "<result>"

    Examples:
      | username | password | result  |
      | test01   | test01   | present |