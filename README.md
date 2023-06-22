# Validation

## ControlsFX

- [JavaFX | ControlsFX validation Framework | How to use?](https://www.youtube.com/watch?v=T-gjV-MPREg)
- [ControlsFX](https://github.com/controlsfx/controlsfx)

## ValidatorFX

- [ValidatorFX](https://www.youtube.com/watch?v=dSYsuPuYaZ8)
- [ValidatorFX](https://github.com/effad/ValidatorFX)

Why not ControlsFX?

- allows validation of a single ui controls only
- ui controls must derive from class _Control_, therefore **not all** node types may be validated
- uses internal JavaFX-API, which results in JPMS problems ("_that's really true_")
