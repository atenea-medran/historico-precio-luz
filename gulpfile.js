const gulp = require('gulp');
const freemarker = require('gulp-freemarker');

gulp.task('default', function() {
    gulp.watch('templates/**/*.ftl', ['freemarker']);
});

gulp.task('freemarker', function() {
    return gulp.src('templates/**/*.ftl')
        .pipe(freemarker())
        .pipe(gulp.dest('dist'));
});
