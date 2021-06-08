1. Client shall sha encrypt (AppId, password, url, timestamp) as token1 and send to API server.
2. API server decrypt (AppId, password, url, timestamp), 
   check if current timestamp is within valid time , if no reject it.
   if yes, query password by AppId, then re-calculate (AppId, password, url, timestamp) token2, check if token1==token2. 
   if yes, authenticate the api call, 
   otherwise reject it.
   
Note: allow different AppId and password storage. Redis, local properties file, database, cloud, zookeeper