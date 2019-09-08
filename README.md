[![Build Status](https://weidongxu.visualstudio.com/appservice/_apis/build/status/weidongxu84.text-normalization?branchName=master)](https://weidongxu.visualstudio.com/appservice/_build/latest?definitionId=1&branchName=master)

# text-normalization

### Concept
Normalize text of certain encoding to UTF-8

### Deployment
https://text-normalization.azurewebsites.net

### Sample
```
curl -X POST -F 'file=@SomeTextFile' https://text-normalization.azurewebsites.net
```
