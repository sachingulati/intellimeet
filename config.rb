# Require any additional compass plugins here.

# ==============================================================================
# COMPASS SOURCE DIRECTORY CONFIGURATION
# ==============================================================================

css_dir = "web-app/css"
sass_dir = "web-app/sass"
fonts_dir = "web-app/fonts"
images_dir = "web-app/images"
javascripts_dir = "web-app/js"
prefered_syntax = :scss

# ==============================================================================
# COMPASS TARGET DIRECTORY CONFIGURATION
# ==============================================================================

http_path = "../"
http_css_path = http_path + "web-app/css"
http_fonts_path = http_path + "web-app/fonts"
http_images_path = http_path + "web-app/images"
http_javascripts_path = http_path + "web-app/js"

# You can select your preferred output style here (can be overridden via the command line):
# output_style = :expanded or :nested or :compact or :compressed

# To enable relative paths to assets via compass helper functions. Uncomment:
# relative_assets = true

# To disable debugging comments that display the original location of your selectors. Uncomment:
# line_comments = false


# If you prefer the indented syntax, you might want to regenerate this
# project again passing --syntax sass, or you can uncomment this:
# preferred_syntax = :sass
# and then run:
# sass-convert -R --from scss --to sass sass scss && rm -rf sass && mv scss sass
