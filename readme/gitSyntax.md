
# Commit Message Syntax

Commit messages should follow a clear and standardized convention to maintain the readability and traceability of the project. This standard is based on [Conventional Commits](https://www.conventionalcommits.org/) and aims to clarify the type of change, provide context, and make development more structured.

## General Format

- **type**: The type of change (see the list of types below).
- **scope** (optional): The part of the project affected by the change (e.g., a service, a module).
- **message**: A short description of the changes (in imperative and present tense).

## Commit Types

- **feat**: Adding a new feature.
  - Example: `feat(user-auth): add login feature`

- **fix**: Bug fixes.
  - Example: `fix(payment): resolve rounding issue in invoice calculation`

- **chore**: Minor tasks that do not affect application code (e.g., dependency updates).
  - Example: `chore: update dependencies`

- **docs**: Documentation updates.
  - Example: `docs(readme): add usage instructions`

- **style**: Code style changes (formatting, indentation, etc.) with no functional impact.
  - Example: `style: fix indentation in codebase`

- **refactor**: Code refactoring with no behavior changes.
  - Example: `refactor(order-service): simplify method flow`

- **test**: Adding or modifying tests.
  - Example: `test(user-service): add unit tests`

- **perf**: Performance improvements.
  - Example: `perf(api): improve database query performance`

- **ci**: Changes related to continuous integration or build tools.
  - Example: `ci: update GitHub Actions configuration`

## Best Practices

- **Clear and Precise Messages**: The message should be explicit and not exceed one line. If additional details are needed, they can be included in the commit body.
- **Imperative and Present Tense**: Use imperative present tense to describe what the commit does, e.g., "add", "fix", "update".
- **Optional Scope**: The scope is useful for indicating the part of the project affected by the commit but can be omitted if not relevant.
- **Avoid Vague Terms**: Avoid using vague terms like `update`, `change`, or `improve`, which lack precision.

## Commit Examples

- **Adding a Feature**:
  ```
  feat(user-auth): add support for two-factor authentication
  ```

- **Bug Fix**:
  ```
  fix(cart): resolve issue with item quantity calculation
  ```

- **Documentation Update**:
  ```
  docs(api): add usage examples for the payment endpoint
  ```
