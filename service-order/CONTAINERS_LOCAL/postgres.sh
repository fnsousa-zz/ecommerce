docker run -d \
    --name db_order \
    -e POSTGRES_PASSWORD=admin \
    -p 5432:5432 \
    -v ~/docker/ecommerce/order/postgres:/var/lib/postgresql/data \
    postgres

