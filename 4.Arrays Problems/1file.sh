#!/bin/bash

# Define the starting and ending numbers for the file names
START_NUM=100
END_NUM=200

# Define the directory where you want to create the files
# By default, this will be the current directory where the script is run.
# You can change this to a specific path if needed, e.g., FILES_DIR="/home/youruser/java_projects"
FILES_DIR="."

echo "Creating Java files from P${START_NUM}.java to P${END_NUM}.java in ${FILES_DIR}..."
echo "-----------------------------------------------------------------"

# Loop from START_NUM to END_NUM
for i in $(seq $START_NUM $END_NUM); do
    # Construct the filename
    FILE_NAME="${FILES_DIR}/P${i}_.java"

    # Create the file with a basic class structure
    # The class name will be P<number>_ (e.g., P40_, P41_)
    
    cat > "$FILE_NAME" << EOF

public class P${i}_ {

    public static void main(String[] args) {
        // Your code here
    }
}
EOF

    # The 'touch' command is commented out as we are now adding content
    # touch "$FILE_NAME"

    echo "Created: $FILE_NAME"
done

echo "-----------------------------------------------------------------"
echo "All specified Java files have been created with the basic class structure."
echo "You can verify by running: ls P*.java"


