%w(A B C).each do |label|
  context label do
    example do
      expect(true).to be true
    end
  end
end
