help(){
    echo "'use bash ./script.sh -d 2' to mark problem 2 done"
    echo "'use bash ./script.sh -n 2' to mark problem 2 not done"
}


done_(){
    sed -i "s/^|[[:space:]]*$1[[:space:]]*|[[:space:]]*|/|$1|:heavy_check_mark:|/" ./readme.md
}

nDone_(){
    sed -i "s/^|[[:space:]]*$1[[:space:]]*|[[:space:]]*:heavy_check_mark:[[:space:]]*|/|$1||/" ./readme.md
}

while getopts ":d:n:" opt; do
    case $opt in
        d) serial="$OPTARG"
        done_ $serial
        ;;
        n) serial="$OPTARG"
        nDone_ $serial
        ;;
        \?) help
        exit 1;;
    esac
    
    case $OPTARG in
        -*) echo "Option $opt needs a valid argument"
            exit 1
        ;;
    esac
done
