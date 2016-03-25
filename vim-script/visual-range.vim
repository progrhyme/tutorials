let pos = getpos(".")
normal `<
echo line(".")
echo col(".")
" 選択開始位置を出力

normal `>
echo line(".")
echo col(".")
" 選択終了位置を出力

call setpos('.', pos)
