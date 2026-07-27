# test-data-protos

Protobuf definitions for test data, published as both a **Java** package (GitHub Packages Maven) and an **npm** package (GitHub Packages npm registry, TypeScript-ready).

## Proto structure

```
Root
└── data[]          ← repeated DataEntry
    └── dates[]     ← repeated DateRecord (multiple dates per entry)
        ├── a[]     ← repeated double
        ├── b[]     ← repeated double
        │   ...
        └── z[]     ← repeated double  (26 fields total, a–z)
```

See [`proto/data.proto`](proto/data.proto) for the full definition.

## Packages

### Java (GitHub Packages Maven)

```xml
<!-- Maven -->
<dependency>
  <groupId>com.github.subhajitdas298</groupId>
  <artifactId>test-data-protos</artifactId>
  <version>1.0.1</version>
</dependency>
```

```kotlin
// Gradle (Kotlin DSL)
implementation("com.github.subhajitdas298:test-data-protos:1.0.1")
```

### TypeScript / npm (GitHub Packages npm)

```bash
npm install @subhajitdas298/test-data-protos
```

```typescript
import { Root, DataEntry, DateRecord } from "@subhajitdas298/test-data-protos";
```

## CI / Publishing

Every pull request and push to `main` runs a build-only CI check (no publishing). Both packages are published automatically only when a GitHub Release is published, using the release tag (e.g. `v1.2.3` → `1.2.3`) as the package version.

| Workflow | File |
|---|---|
| CI (build check) | [`.github/workflows/ci.yml`](.github/workflows/ci.yml) |
| Publish Java | [`.github/workflows/publish-java.yml`](.github/workflows/publish-java.yml) |
| Publish npm  | [`.github/workflows/publish-npm.yml`](.github/workflows/publish-npm.yml) |

## Local development

### Java

Requires Java 24.

```bash
./gradlew build
```

### TypeScript codegen

Requires [buf](https://buf.build/docs/installation) and Node 22.

```bash
npm install          # installs protoc-gen-es and typescript
npm run generate     # generates src/data_pb.ts from proto/data.proto via buf
npm run build        # compiles TypeScript → dist/
```