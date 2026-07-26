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

## Build

Requires Java 11+ and Maven 3.6+.

```bash
mvn generate-sources   # compile .proto → Java sources
mvn package            # build the jar
```

Generated Java classes are placed under `target/generated-sources/protobuf`.