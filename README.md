# test-data-protos

A Java project containing Google Protocol Buffer (protobuf) definitions.

## Structure

```
data: [          ← repeated DataEntry
  date: {        ← Date message
    a: [...]     ← repeated string
  }
]
```

### Proto definition

See [`proto/data.proto`](proto/data.proto).

| Message     | Field  | Type                  |
|-------------|--------|-----------------------|
| `Root`      | `data` | `repeated DataEntry`  |
| `DataEntry` | `date` | `Date`                |
| `Date`      | `a`    | `repeated string`     |

## Requirements

- Java 21 (latest LTS)

## Build

```bash
./gradlew build           # compile .proto → Java and build the jar
./gradlew generateProto   # generate Java sources from .proto only
```

Generated Java classes are placed under `build/generated/source/proto/main/java`.