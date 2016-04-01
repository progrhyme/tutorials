#!/usr/bin/env perl
use strict;
use warnings;
use feature 'say';

my $v = shift([qw/foo bar/]); # ok
#my $v = shift(('foo', 'bar')); # err
say $v;

my @a = qw/foo bar/;
say shift @a;
