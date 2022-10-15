#!/bin/bash
if test $# -eq 0
then
    exit 1
else
    mkdir -p $1
fi


number=$(ls -a src | grep ... | wc -l)

number2=0
cmd=0
while(($number2!=number))
     do
	 cmd=$(ls -a src | grep . | head | grep ... | tr "\n" " " |  awk -F" " '{print $$number2}')
	 number2=$number2+1
done


echo $cmd | head -1 | tr " " "\n"

echo "-------------------------------------------"

number3=$(ls -a tst | grep ... | wc -l)

number4=0
cmd2=0
while(($number4!=number3))
     do
	 cmd2=$(ls -a tst | grep . | head | grep ... | tr "\n" " " |  awk -F" " '{print $$number4}')
	 number4=$number4+1
done

echo $cmd2 | head -1 | tr " " "\n"

echo -e "==========================================================="
