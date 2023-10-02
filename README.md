# lazycolum-sizing-bug
Reproducing a lazycolumn sizing bug when using Modifier.height(IntrinsicSize.Min)

Expected result: all list items show 2 lines of the same text with no extra space

Actual result: some items will be sized larger than expected and will contain extra space,
scrolling away and back to the item will 'fix' it.
