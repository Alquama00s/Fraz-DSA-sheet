help(){
    echo "'use bash ./script.sh -d 2' to mark problem 2 done"
    echo "'use bash ./script.sh -n 2' to mark problem 2 not done"
    echo "'use bash ./script.sh -c 2.prob-name' to create desired folder structure and open code"
    echo "u can also set fraz variable to rood project path and the call this script from any location"
}


done_(){
    sed -i "s/^|[[:space:]]*$1[[:space:]]*|[[:space:]]*|/|$1|:heavy_check_mark:|/" ./readme.md
}

nDone_(){
    sed -i "s/^|[[:space:]]*$1[[:space:]]*|[[:space:]]*:heavy_check_mark:[[:space:]]*|/|$1||/" ./readme.md
}

create(){
    this=`pwd`
    if [[ $fraz != "" ]]
    then
        cd $fraz
    fi
    mkdir $1
    cd ./$1
    touch Solution.java
    echo "public class Solution{}" >> ./Solution.java
    code .
    cd $this
}

while getopts ":d:n:c:" opt; do
    case $opt in
        d) serial="$OPTARG"
            done_ $serial
        ;;
        n) serial="$OPTARG"
            nDone_ $serial
        ;;
        c) name="$OPTARG"
            create $name
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
