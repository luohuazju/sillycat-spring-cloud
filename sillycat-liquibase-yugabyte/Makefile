

run-db:
	docker run -d --name yugabyte \
  		-p 15432:15432 -p5433:5433 \
        yugabytedb/yugabyte:latest \
        bin/yugabyted start --daemon=false