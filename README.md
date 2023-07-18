# user-data-service

## Dockerize and push to dockerhub
- `docker build -t user-data-service:latest .`
- `docker tag user-auth-service:latest <dockerhub-username>/user-auth-service:latest`

## Install Minikube to run on K8
- Generate the command from the link to install minikube: https://minikube.sigs.k8s.io/docs/start/
- minikube start

## Apply K8 Manifest files
- `kubectl apply -f kubernetes/user-auth-service.yaml`

## Test Service on K8
-  `curl http://user-data-service.default.svc.cluster.local:8082/user_data/user1`
-  `curl http://user-data-service:8082/user_data/user1`
