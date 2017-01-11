# Movie Fun!

## Build

### Build JAR

```bash
$ ./gradlew clean assemble
```

### Run Smoke Tests

```bash
./gradlew test
```

Smoke Tests require server running on port 8080 by default. To run against a custom URL run
```bash
$ MOVIE_FUN_URL=http://moviefun.example.com ./gradlew test
```

## Deploying to PCF

After running the build, deploy the application with
```bash
./gradlew deploy
```

Reset the entire PCF environment with
```bash
./gradlew resetPcfEnv
```

## Migrations

Create databases needed for local development with

```bash
mysql -uroot < databases/create_databases.sql
```

Run local migrations with

```bash
./gradlew flywayMigrate
```

Run migrations on the PCF environment which you're logged in to with

```bash
./gradlew cfMigrate
```
