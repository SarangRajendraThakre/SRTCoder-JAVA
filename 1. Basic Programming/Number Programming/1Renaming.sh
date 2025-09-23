#!/bin/bash

# Define the directory where your files are located
# If the script is in the same directory, use "."
DIR="."

# Check if the directory exists
if [ ! -d "$DIR" ]; then
    echo "Error: Directory '$DIR' not found."
    exit 1
fi

# Loop through all files that match the pattern P*_C_*.java
for filename in "$DIR"/P*_P_*.java; do
    # Check if any files were found
    if [ ! -f "$filename" ]; then
        echo "No files matching the pattern 'P*_C_*.java' were found."
        break
    fi

    # 1. Rename the file
    new_filename=$(echo "$filename" | sed 's/_C_/_P_/')
    mv "$filename" "$new_filename"
    echo "Renamed '$filename' to '$new_filename'"

    # 2. Update the class name inside the file
    # Get the original class name (e.g., P9_C_LargestOfThreeNumbers)
    # The basename removes the path and extension
    original_classname=$(basename "$filename" .java)
    
    # Get the new class name (e.g., P9_P_LargestOfThreeNumbers)
    new_classname=$(echo "$original_classname" | sed 's/_C_/_P_/')

    # Use sed to replace the class name.
    # The 's' command is for substitute. The g flag is for global replacement.
    # Note: Using `sed -i` for in-place editing.
    sed -i "s/class $original_classname/class $new_classname/g" "$new_filename"
    echo "Updated class name in '$new_filename' from '$original_classname' to '$new_classname'"
    echo "---------------------------------------------------"
done

echo "Script finished successfully."
