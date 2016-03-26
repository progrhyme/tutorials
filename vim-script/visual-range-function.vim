function! Func() range
  let tmp = @@
  silent normal gvy
  let selected = @@
  let @@ = tmp
  echo selected
endfunction

command! -range Func :call Func()
