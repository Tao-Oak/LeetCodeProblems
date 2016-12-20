" set indentation rules for my project
set tabstop=4
set softtabstop=4
set shiftwidth=4
set noexpandtab

" line's cha counts control, highlight the last column of each line
set colorcolumn=120
highlight ColorColumn ctermbg=darkgray

" file type detection
"augroup project
"	autocmd!
"	autocmd BufRead,BufNewFile *.h,*.c set filetype=c.doxygen
"augroup END

" setting path variable
let &path.="pjlib/,pjlib-util/,pjmedia/,pjnath/,pjsip/,thrid_party/,"

" key mapping
map <F2> :NERDTreeToggle<CR>
