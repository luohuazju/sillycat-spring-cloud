

run-db:
	docker run -d --name yugabyte \
  		-p 15432:15432 -p5433:5433 \
  		-v yugabytedb-data:/var/lib/yugabyte \
        yugabytedb/yugabyte:latest \
        bin/yugabyted start --daemon=false \
        --tserver_flags="memory_limit_hard_bytes=268435456,max_clock_skew_usec=500000" \
  		--master_flags="memory_limit_hard_bytes=268435456"
  		
clean-db:
	docker stop yugabyte
	docker rm yugabyte