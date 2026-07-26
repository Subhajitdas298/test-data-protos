# test-data-protos

A Go project containing Google Protocol Buffer (protobuf) definitions.

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

## Generate Go code

```bash
protoc --go_out=. --go_opt=paths=source_relative proto/data.proto
```