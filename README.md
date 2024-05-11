# github-username-checker-project
Project that utilizes HTTP to request response codes using proxies to find out if a GitHub username would be linked to a particular account using a wordlist.
### DISCLAIMERS
- By removing the "Thread.sleep();" line, you remove the restriction on how much requests you are sending a minute/hour. Without the sleep, the program would make HTTP requests to GitHub in rapid succession without any delay between requests, and may come across as a potential DDOS attack against GitHub.
- Using this method of Checking the 404 and 200 Requests, some accounts may exist, but output a 404 Request. Example: [w](https://github.com/w). This may be because the account was either Disabled or Suspended.

## How to use this program
- Assign a path to a Wordlist string
- Assign a proxy Address and port
- By running the program, it will check each of the names you have stored in your Wordlist to see if they may or may not exist.
